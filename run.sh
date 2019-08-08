#!/bin/bash

run_module(){
  custom-jre/bin/java -Xms128m -Xmx128m --module-path mods \
  -m bookstore.main/br.com.bookstore.Main
}

run_jar(){
  custom-jre/bin/java -Xms128m -Xmx128m -p lib -m bookstore.main
}

#Build JRE
bash scripts/link.sh

#Build Modules
bash scripts/build.sh

#Package Modules
bash scripts/package.sh

echo ""
echo -e "\e[0;36m===========================\e[0m"
echo -e "\e[0;36mRunning Application Module\e[0m"
echo -e "\e[0;36m===========================\e[0m"

run_module

echo ""
echo -e "\e[0;36m===========================\e[0m"
echo -e "\e[0;36mRunning Application Jar\e[0m"
echo -e "\e[0;36m===========================\e[0m"

run_jar
