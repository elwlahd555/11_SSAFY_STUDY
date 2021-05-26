import requests
import csv
from bs4 import BeautifulSoup

name = open('C:\ssafy\itemname.txt', 'rt', encoding='UTF8')
file = open('C:\\ssafy\\temptemptemp.txt', 'w')

i = 5753
while True:
    i = i+1
    keyword = name.readline()
    if not keyword:
        break
    # file.write(keyword)
    print(keyword)

    url = "http://browse.auction.co.kr/search?keyword="+keyword
    headers = {
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36'}
    req = requests.get(url, headers=headers)
    html = req.content
    soup = BeautifulSoup(html, 'html.parser')
    imageList = []

    # print(soup.find('a',class_='link--itemcard').get('href'))

    url2 = soup.find('a', class_='link--itemcard')
    if(url2):
        req2 = requests.get(url2.get('href'))
        html2 = req2.content
        soup2 = BeautifulSoup(html2, 'html.parser')

        for img in soup2.find_all('img'):
            if img.get('src'):
                if len(imageList) > 5:
                    break
                if img.get('src')[7:12] == 'image':
                    imageList.append(img.get('src'))

    for image in imageList:
        file.write(str(i) + ';' +
                   keyword[:len(keyword)-1] + ';' + image + '\n')
        # file.write(keyword)
        # file.write(image)

    # print(imageList + '\n')
file.close()
