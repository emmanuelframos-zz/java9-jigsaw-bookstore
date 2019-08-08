# Java 9 Jigsaw - Bookstore
A bookstore using Java 9 Jigsaw, HTTP2/Client and Flow API.

## Building a custom(small) JRE
Execute script **scripts/link.sh** in root directory:
~~~
bash scripts/link.sh
~~~

## Modules
* **Domain**: contains domain classes of business core
* **HTTP**: HTTP client to get books from external service
* **NF**: invoice issuing service and domain objects
* **Main**: executes the entire flow 

## Building modules
Execute script **scripts/build.sh** in root directory:
~~~
bash scripts/build.sh
~~~

## Packaging modules
Execute script **scripts/package.sh** in root directory:
~~~
bash scripts/package.sh
~~~

## Running
Execute script **run.sh** in root directory:
~~~
bash run.sh
~~~

## Versions
Java 9.0.7


