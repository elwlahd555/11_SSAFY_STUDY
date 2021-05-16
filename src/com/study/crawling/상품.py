import requests
from bs4 import BeautifulSoup
webpage = requests.get(
    "https://www.google.com/search?q=%ED%94%8C%EB%A3%A8%EC%9D%B4%EB%93%9C+%EC%85%94%EC%B8%A0+%EC%9B%90%ED%94%BC%EC%8A%A4+(SWWSTK22050)&sxsrf=ALeKk03iecBFaYRGYVHr-fjzlnz_EtEuvQ:1621157809948&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjiyou7883wAhUNM94KHbSoBzoQ_AUoAXoECAEQAw&biw=1318&bih=706")
soup = BeautifulSoup(webpage.content, "html.parser")
# print(soup)

all_uls = soup.select_one('#ty_thmb_view > ul > li')
# print(all_uls)
#
# for li in soup.find_all('ul'):

#     print(li.select('img.src'))

# for li in soup.select('#ty_thmb_view > ul > li'):
#     print("상품명"+li.select('#tx_ko'))
#     print('-----------------------------------------------')

# print(li.select_one('div> div> a'))
# ty_thmb_view > ul > li:nth-child(2)
# ty_thmb_view > ul > li:nth-child(2) > div.cunit_prod > div.thmb > a

img = soup.select(
    '#islrg > div.islrc > div:nth-child(1) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img')
print(img)
# \34 833701282 > a > dl > dt > img
