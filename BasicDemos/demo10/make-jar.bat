
call env



md %dist%

cd %bin%

jar cfm %dist%\fshop.jar  %root%\manifest.info .

cd %dist%

echo @java -cp fshop.jar in.conceptarchitect.app.App  >fshop.bat

