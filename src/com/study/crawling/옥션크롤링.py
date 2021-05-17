import requests
from bs4 import BeautifulSoup


keyword={"타임리스 스트라이프 벨티드 원피스_P302013831"}
for key in keyword:
    url = "http://browse.auction.co.kr/search?keyword="+key
    headers={'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36'}
    req = requests.get(url,headers=headers)
    html = req.content
    soup = BeautifulSoup(html, 'html.parser')
    imageList = []

    # print(soup.find('a',class_='link--itemcard').get('href'))


    url2=soup.find('a',class_='link--itemcard')
    if(url2.get('href')):
        req2=requests.get(url2.get('href'))
        html2=req2.content
        soup2=BeautifulSoup(html2,'html.parser')

#hdivDescription > center > div > div.wrap > div > div > center > img:nth-child(1)
        center = soup2.find_all('img')
        for temp in center:
            print(temp.get('src'))
        # for img in soup2.find_all('center > img'):
        #     if img.get('src'):
        #         if len(imageList) > 5:
        #             break
        #         if img.get('src')[7:12] == 'image':
        #             imageList.append(img.get('src'))

        # for image in imageList:
        #     print(image+key)
