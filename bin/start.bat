@echo off
chcp 65001
setlocal enabledelayedexpansion

:: git 提交信息，由用户输入获取
set /p DESCRIPTION="请输入提交信息: "
:: 如果用户直接回车，则使用默认的提交说明
if not defined DESCRIPTION (
	DESCRIPTION="默认提交说明"
)
:: 当前是在git管理目录的上一级，需要进到git管理的目录下使用git命令
cd \E "ZStudy\SummerDemo\Algorithm\bin"
:: 拉取最新代码
git pull origin master
:: 将所有文件加入到缓冲区
git add .
:: 提交
git commit -m "!DESCRIPTION!"
if %ERRORLEVEL% NEQ 0 (
    echo An error occurred during git pull.
    exit /b %ERRORLEVEL%
)
:: 推送到远程仓库
git push origin master

echo Commit successful.
endlocal
:: 暂停窗口，调试可用，正式使用可以注释掉下面代码，就会自动关闭窗口
pause
