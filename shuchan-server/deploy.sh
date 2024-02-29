#!/bin/bash
set -e
 
## 第一步：删除可能启动的老 shuchan-server 容器
echo "开始删除 shuchan-server 容器"
docker stop shuchan-server || true
docker rm shuchan-server || true
echo "完成删除 shuchan-server 容器"
 
## 第二步：启动新的 shuchan-server 容器 \
echo "开始启动 shuchan-server 容器"
docker run -d \
--name shuchan-server \
-p 48080:48080 \
-e "SPRING_PROFILES_ACTIVE=dev" \
-v /work/projects/shuchan-server:/root/logs/ \
shuchan-server
echo "正在启动 shuchan-server 容器中，需要等待 60 秒左右"
