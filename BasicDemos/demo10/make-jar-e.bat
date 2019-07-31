
call env



md %dist%

cd %bin%

jar cfe %dist%\fshop2.jar  in.conceptarchitect.app.App .

cd %dist%

echo @java -jar fshop2.jar >fshop2.bat



