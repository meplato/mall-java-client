.PHONY: build jar test

all: build

build:
	mvn compile

jar:
	mvn package

test:
	mvn test
