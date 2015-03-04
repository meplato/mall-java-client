APIGEN_DIR=~/gocode/src/meplatolabs.com/api
APIGEN=$(APIGEN_DIR)/apigen

all: clean generate

clean:
	rm -rf gen \
		src/main/java/com/meplato/mall/Service.java \
		src/main/java/com/meplato/mall/mlt/Service.java \
		src/main/java/com/meplato/mall/catalogs/Service.java \
		src/main/java/com/meplato/mall/products/Service.java

generate:
	mkdir -p src/main/java/com/meplato/mall \
		src/main/java/com/meplato/mall/mlt \
		src/main/java/com/meplato/mall/catalogs \
		src/main/java/com/meplato/mall/products
	$(APIGEN) -l java -i spec/catalogs.yaml -o src/main/java/com/meplato/mall/catalogs/
	$(APIGEN) -l java -i spec/products.yaml -o src/main/java/com/meplato/mall/products/
	$(APIGEN) -l java -i spec/more-like-this.yaml -o src/main/java/com/meplato/mall/mlt/
