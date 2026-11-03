@echo off
setlocal
set "BASE=%~dp0"
for /f "tokens=1,* delims==" %%a in ('findstr /b "distributionUrl=" "%BASE%.mvn\wrapper\maven-wrapper.properties"') do set "URL=%%b"
set "NAME=apache-maven-3.9.9"
set "DIR=%USERPROFILE%\.m2\wrapper\dists\%NAME%"
if not exist "%DIR%\%NAME%\bin\mvn.cmd" (
  mkdir "%DIR%" 2>nul
  powershell -NoProfile -Command "[Net.ServicePointManager]::SecurityProtocol=[Net.SecurityProtocolType]::Tls12; Invoke-WebRequest -Uri '%URL%' -OutFile '%DIR%\m.zip'; Expand-Archive -Force '%DIR%\m.zip' '%DIR%'; Remove-Item '%DIR%\m.zip'"
)
"%DIR%\%NAME%\bin\mvn.cmd" %*
endlocal
