from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
import pprint
# from oauth2client.tools import argparser

# api key객체 생성
DEVELOPER_KEY = "AIzaSyDzZlEup7tbpw-uO9qhnZ4Wnw0X7RpOONw"
YOUTUBE_API_SERVICE_NAME = "youtube"
YOUTUBE_API_VERSION = "v3"

# build(googleapiclient.discovery) 객체 생성
youtube = build(YOUTUBE_API_SERVICE_NAME, YOUTUBE_API_VERSION,
                developerKey=DEVELOPER_KEY)

search_response = youtube.search().list(
    q="아이유",
    order="relevance",
    part="snippet",
    maxResults=10
).execute()
for i in range(0,9):
    search_result = search_response.get("items", [])[i]
    print(search_result["snippet"]["title"])
    print(search_result["id"]["videoId"])
    data = "https://www.youtube.com/watch?v=" + \
        search_result["id"]["videoId"] + "\n"
    

