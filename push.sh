#! /bin/bash
cd E:/ZStudy/SummerDemo/Algorithm
echo "----------本地库状态----------"
git status
echo "----------本地库状态----------"
while :
do
    read -r -p "是否继续提交？[Y/N]" input
    case $input in
        [yY][eE][sS]|[yY])
            echo "----------继续提交----------"
            createAt=$(date "+%Y-%m-%d %H:%M:%S")
            git pull origin master
            git add .
            git commit -m "${createAt}"
            git push origin master
            echo "----------提交成功----------"
            ;;
        [nN][oO]|[nN])
            echo "----------中断提交----------"
            sleep 1
            exit 1
                ;;
        *)
        echo "输入有误，请重新输入"
        continue
        ;;
    esac
done