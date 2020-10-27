find -name "*.java" > sources.txt &&
find . -type f -name "*.class" -delete &&
javac @sources.txt &&
cd src &&
java App &&
cd -
