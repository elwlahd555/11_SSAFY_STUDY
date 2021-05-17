import requests
from bs4 import BeautifulSoup




url = "https://front.wemakeprice.com/product/1711147124?search_keyword=%25ED%2583%2580%25EC%259E%2584%25EB%25A6%25AC%25EC%258A%25A4%2520%25EC%258A%25A4%25ED%258A%25B8%25EB%259D%25BC%25EC%259D%25B4%25ED%2594%2584%2520%25EB%25B2%25A8%25ED%258B%25B0%25EB%2593%259C%2520%25EC%259B%2590%25ED%2594%25BC%25EC%258A%25A4_P302013831&_service=5&_no=1"
headers={'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36'}
req = requests.get(url,headers=headers)
html = req.content
soup = BeautifulSoup(html, 'html.parser')
imageList = []

    # print(soup.find('a',class_='link--itemcard').get('href'))


# url2=soup.find('a',class_='link--itemcard')
# if(url2.get('href')):
#     req2=requests.get(url2.get('href'))
#     html2=req2.content
#     soup2=BeautifulSoup(html2,'html.parser')

#hdivDescription > center > div > div.wrap > div > div > center > img:nth-child(1)
center = soup.find_all('img')
for temp in center:
    print(temp)
        # for img in soup2.find_all('center > img'):
        #     if img.get('src'):
        #         if len(imageList) > 5:
        #             break
        #         if img.get('src')[7:12] == 'image':
        #             imageList.append(img.get('src'))

        # for image in imageList:
        #     print(image+key)
