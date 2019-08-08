#!/bin/sh

JRE_DIR="custom-jre"

link(){
  jlink --module-path $JAVA_HOME/jmods \
  --add-modules java.base,jdk.incubator.httpclient \
  --output $JRE_DIR
}

echo ""
echo -e "\e[0;36m======================\e[0m"
echo -e "\e[0;36mBuilding custom JRE\e[0m"
echo -e "\e[0;36m======================\e[0m"

link

echo "Custom JRE built"
