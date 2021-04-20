#!/bin/sh
mkdir -p build &&
cp -r lib ./build &&
cp -r res ./build &&
javac -cp ./src:./lib/json-simple-1.1.1.jar src/App.java -d ./build/bin &&
javac -cp ./src:./lib/json-simple-1.1.1.jar src/app/controllers/*.java -d ./build/bin &&
jar -cvfm ./build/boom.jar .manifest -C build/bin .
