/*
 * Copyright (c) 2017 Meplato GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.meplato.mall.commands;

import com.google.gson.Gson;
import com.meplato.mall.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;

public class Commands {
    public static void main(String[] args) {
        try {
            new Commands().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run(String[] args) throws Exception {
        Client client = getClient();

        if (args.length == 0) {
            listCatalogs(client,"", 0, 100, "id");
            return;
        }

        switch (args[0]) {
            case "catalogs":
                listCatalogs(client,"", 0, 100, "id");
                break;
            case "download":
                if (args.length <= 1) {
                    throw new IllegalArgumentException("missing catalog id");
                }
                int catalogId = Integer.parseInt(args[1]);
                downloadCatalog(client, catalogId);
        }
    }

    private Client getClient() throws Exception {
        boolean useOkHttp = null != System.getenv("USE_OKHTTP");
        boolean useJetty = null != System.getenv("USE_JETTY");

        Client client;
        if (useOkHttp) {
            okhttp3.OkHttpClient httpClient = new okhttp3.OkHttpClient();
            client = new OkHttpClient(httpClient);
        } else if (useJetty) {
            SslContextFactory.Client sslContextFactory = new SslContextFactory.Client();
            org.eclipse.jetty.client.HttpClient httpClient = new org.eclipse.jetty.client.HttpClient(sslContextFactory);
            httpClient.start();
            client = new JettyHttpClient(httpClient);
        } else {
            client = new ApacheHttpClient();
        }

        return client;
    }

    private com.meplato.mall.catalogs.Service getCatalogsService(Client client) {
        com.meplato.mall.catalogs.Service svc = new com.meplato.mall.catalogs.Service(client);
        String user = System.getenv("MALL_USER");
        if (user != null && user != "") {
            svc.setUser(user);
        }
        String password = System.getenv("MALL_PASSWORD");
        if (password != null && password != "") {
            svc.setPassword(password);
        }
        String baseURL = System.getenv("MALL_URL");
        if (baseURL != null && baseURL != "") {
            svc.setBaseURL(baseURL);
        }
        return svc;
    }

    private com.meplato.mall.products.Service getProductsService(Client client) {
        com.meplato.mall.products.Service svc = new com.meplato.mall.products.Service(client);
        String user = System.getenv("MALL_USER");
        if (user != null && user != "") {
            svc.setUser(user);
        }
        String password = System.getenv("MALL_PASSWORD");
        if (password != null && password != "") {
            svc.setPassword(password);
        }
        String baseURL = System.getenv("MALL_URL");
        if (baseURL != null && baseURL != "") {
            svc.setBaseURL(baseURL);
        }
        return svc;
    }

    private void listCatalogs(Client client, String keywords, int skip, int take, String sort) {
        com.meplato.mall.catalogs.Service svc = getCatalogsService(client);

        try {
            com.meplato.mall.catalogs.SearchResponse response = svc.search().q(keywords).skip(skip).take(take).sort(sort).pretty(true).execute();

            System.out.printf("Total %d catalogs\n", response.getTotalItems());

            for (com.meplato.mall.catalogs.Catalog catalog : response.getItems()) {
                System.out.printf("* %s)\n", catalog.getTitle());
                System.out.printf("  ID             : %d\n", catalog.getId());
                System.out.printf("  PIN            : %s\n", catalog.getStorePin());
                System.out.printf("  Language       : %s\n", catalog.getLanguage());
                System.out.printf("  Currency       : %s\n", catalog.getCurrency());
                System.out.printf("  Valid from     : %s\n", catalog.getValidFrom());
                System.out.printf("  Valid until    : %s\n", catalog.getValidUntil());
                // System.out.printf("  Expired        : %d\n", catalog.getExpired());
                if (catalog.getCatalogManaged() != null) {
                    System.out.printf("  Catalog managed: %b\n", catalog.getCatalogManaged());
                }
                if (catalog.getLastSyncAt() != null) {
                    System.out.printf("  Last sync      : %s\n", catalog.getLastSyncAt());
                    System.out.printf("  Sync version   : %d\n", catalog.getSyncVersion());
                } else {
                    System.out.println("  Last sync      : never");
                }
                if (catalog.getCreated() != null) {
                    System.out.printf("  Created        : %s\n", catalog.getCreated());
                }
                if (catalog.getUpdated() != null) {
                    System.out.printf("  Updated        : %s\n", catalog.getUpdated());
                }
            }

        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    private void downloadCatalog(Client client, int catalogId) {
        com.meplato.mall.products.Service svc = getProductsService(client);

        String pageToken = null;
        long current = 0, total = 0;

        Gson gson = com.meplato.mall.products.Service.getSerializer();

        System.out.println("[");

        while (true) {
            try {
                com.meplato.mall.products.ScrollResponse response = svc.scroll().catalogId(catalogId).pageToken(pageToken).execute();
                if (total == 0) {
                    total = response.getTotalItems();
                }
                if (response.getItems() != null) {
                    current += response.getItems().length;
                }
                long percent = 0;
                if (total > 0) {
                    percent = (long)(((double)current*100.0)/(double)total);
                }
                pageToken = response.getPageToken();
                if (pageToken == null || pageToken == "") {
                    break;
                }
                System.err.printf("%03d%% | %07d of %07d   \r", percent, current, total);

                // Serialize as JSON and print to stdout
                for(com.meplato.mall.products.Product product : response.getItems()) {
                    String output = gson.toJson(product);
                    System.out.println(output);
                }

            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }

        System.out.println("]");

        System.err.println();
    }

}
