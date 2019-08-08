#!/bin/bash

LIB_DIR="lib"

package_domain(){
  jar --create \
    --file=lib/bookstore.domain-1.0.jar \
    --module-version 1.0 \
    -C mods/bookstore.domain .
}

package_http(){
  jar --create \
    --file=lib/bookstore.http-1.0.jar \
    --module-version 1.0 \
    -C mods/bookstore.http .
}

package_nf(){
  jar --create \
    --file=lib/bookstore.nf-1.0.jar \
    --module-version 1.0 \
    -C mods/bookstore.nf .
}

package_main(){
  jar --create \
    --file=lib/bookstore.main-1.0.jar \
    --module-version 1.0 \
    --main-class=br.com.bookstore.Main \
    -C mods/bookstore.main .
}

echo ""
echo -e "\e[0;36m======================\e[0m"
echo -e "\e[0;36mPackaging modules\e[0m"
echo -e "\e[0;36m======================\e[0m"

mkdir -p $LIB_DIR

package_domain
package_http
package_nf
package_main

echo "Modules packaging finished"