
@echo off

call env

md %bin%

javac -d %bin%  %furnitures%\*.java
javac -d %bin%  %data%\*.java
javac -d %bin%  %console%\*.java

javac -cp %cp%  -d %bin% %src%\in\conceptarchitect\app\App.java 

call make-jar

cd %root%

call make-jar-e
