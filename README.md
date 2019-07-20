# Meplato Mall 1.0 API for Java

This is the Java client for the Meplato Mall 1.0 API. It helps you write
software to integrate into the Meplato suite for buyers.

If you're looking for the Meplato Mall 2.0 API client for Java,
[please look here](https://github.com/meplato/mall-api-java).

## Prerequisites

You need at two things to use the Meplato Mall 1.0 API.

1. A login to Meplato Mall 1.0.
2. An API token.

Get your login by contacting Meplato Supplier Network Services. The API token
is required to securely communicate with the Meplato Mall 1.0 API. You can
find it in the personalization section when logged into Meplato Mall 1.0.

## Installation

Run e.g. `mvn compile` and/or `mvn package` to build the Java Archive to use.
Run `mvn test` to run the test suite.

## Getting started

All functionality in the client is separated into services. So you first
need to create and initialize a service, then set its parameters, and finally
execute it. Here's an example of how to retrieve the list of catalogs for
your Meplato Mall account.

```java
import com.meplato.mall.ApacheHttpClient;
import com.meplato.mall.Client;
import com.meplato.mall.ServiceException;
import com.meplato.mall.catalogs.Service;
import com.meplato.mall.catalogs.SearchResponse;
import com.meplato.mall.catalogs.Catalog;

...

// Client is the HTTP Client to use for making HTTP requests.
// The package comes with a default implementation (ApacheHttpClient),
// but feel free to create your own.
Client client = new ApacheHttpClient();

// Instantiate the Catalogs service and set your API token.
Service service = new Service(client);
service.setUser("<your-api-token>");

// Create a search, execute it, and iterate through the results.
SearchResponse response = service.search().skip(0).take(10).sort("-created,name").execute();
System.out.format("You have %d catalog(s).\n", response.getTotalItems());
for (Catalog catalog : response.getItems()) {
    System.out.format("Catalog with ID=%d has name %s.\n", catalog.getId(), catalog.getName());
}
```

Feel free to look at the unit tests to get further information how to use the services.

## Documentation

Complete documentation for the Meplato Mall 1.0 API can be found at
[https://developer.meplato.com/mall](https://developer.meplato.com/mall).

## Testing

Run `mvn test` to run tests. All tests are mocked: No internet access necessary.

# License

This software is licensed under the Apache 2 license.

    Copyright (c) 2015 Meplato GmbH <http://www.meplato.com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

