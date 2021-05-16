import requests
from bs4 import BeautifulSoup


url = "http://itempage3.auction.co.kr/DetailView.aspx?itemno=B884351201"
req = requests.get(url)
html = req.content
soup = BeautifulSoup(html, 'html.parser')
imageList = []


for img in soup.find_all('img'):
    if img.get('src'):
        if len(imageList) > 5:
            break
        if img.get('src')[7:12] == 'image':
            imageList.append(img.get('src'))

for image in imageList:
    print(image)
