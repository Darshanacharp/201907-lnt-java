
@echo off

call env

javac -cp %cp% App.java 

tree /f
