
@echo off

call env

javac -cp %cp% src\App.java 

tree /f
