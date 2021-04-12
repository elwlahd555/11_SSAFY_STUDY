from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
import pprint
# from oauth2client.tools import argparser

# api key객체 생성
DEVELOPER_KEY = "AIzaSyBmK9-jEmCYXotNsa7NagyosJ-GdpPFAG8"
YOUTUBE_API_SERVICE_NAME = "youtube"
YOUTUBE_API_VERSION = "v3"

# build(googleapiclient.discovery) 객체 생성
youtube = build(YOUTUBE_API_SERVICE_NAME, YOUTUBE_API_VERSION,
                developerKey=DEVELOPER_KEY)
f = open("C:\\SSAFY\\music.txt", 'r', encoding='UTF-8')
file = open("C:\\SSAFY\\music01.txt", 'w')
lines = f.readlines()

for line in lines:
    search_response = youtube.search().list(
        q=line,
        order="relevance",
        part="snippet",
        maxResults=1
    ).execute()
    search_result = search_response.get("items", [])[0]
    print(line)
    print(search_result["snippet"]["title"])
    print(search_result["id"]["videoId"])
    data = "https://www.youtube.com/watch?v=" + \
        search_result["id"]["videoId"] + "\n"
    file.write(data)

# if search_result["id"]["kind"] == "youtube#video":
#     print(line)
#     print(search_result["snippet"]["title"])
#     print(search_result["id"]["videoId"])
#     data = "https://www.youtube.com/watch?v=" + \
#         search_result["id"]["videoId"] + "\n"
#     file.write(data)
# for search_result in search_response.get("items", []):
#     if search_result["id"]["kind"] == "youtube#video":
#         print(search_result["snippet"]["title"])
#         print(search_result["id"]["videoId"])
#         data = "https://www.youtube.com/watch?v=" + \
#             search_result["id"]["videoId"] + "\n"
#         file.write(data)
# print(line)
# line = f.readline()
# search_response = youtube.search().list(
#     q="Marry You",
#     order="relevance",
#     part="snippet",
#     maxResults=1
# ).execute()
# search_result = search_response.get("items", [])[0]
# print(search_result["snippet"]["title"])
# print(search_result["id"]["videoId"])

# pprint.pprint(videos)
f.close()
file.close()
