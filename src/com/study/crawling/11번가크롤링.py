from sys import api_version
import requests
from bs4 import BeautifulSoup
def api():
    key="ea3679fc0b52bdb86b5fbb3547d35867"
    keyword="원피스"
    url="https://openapi.11st.co.kr/openapi/OpenApiService.tmall?key="+key+"&apiCode=ProductSearch&keyword="+keyword
    req=requests.get(url)
    xmlRowdata=req.content.decode('cp949')
    soup=BeautifulSoup(xmlRowdata,'html.parser')
    for i in soup.find_all("productimage"):
        print(i)

