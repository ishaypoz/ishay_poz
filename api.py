
import urllib.parse
import urllib.request
import json

from urllib.error import HTTPError

case_key = input('Please Choose (1,2,3,4) for Exit 0 \n 1. /Search \n 2. /Search with more than 1 key \n 3. Get Albums 1 and more \n 4. Get Artist 1 and more \n')

while case_key:
    if case_key == '1':
        search_key = input('iTunes Search: ')
        query = urllib.parse.quote(search_key)
        try:
            response = urllib.request.urlopen('https://itunes.apple.com/search?term=' + query)
            data = json.loads(response.read())
            print(data)
        except HTTPError as e:
            print('Error code: ', e.code)

    if case_key == '2':
        search_key = input('iTunes Search: ')
        limit_key = input('Limit result to: ')
        query = urllib.parse.quote(search_key)
        try:
            response = urllib.request.urlopen('https://itunes.apple.com/search?term=' + query + '&limit=' + limit_key)
            data = json.loads(response.read())
            print(data)
        except HTTPError as e:
            print('Error code: ', e.code)

    if case_key == '3':
        album_key = input('iTunes Albums Search: ')
        query = urllib.parse.quote(album_key)
        try:
            response = urllib.request.urlopen('https://itunes.apple.com/search?term=' + query + '&entity=album')
            data = json.loads(response.read())
            print(data)
        except HTTPError as e:
            print('Error code: ', e.code)

    if case_key == '4':
        artist_key = input('iTunes Artists Search: ')
        query = urllib.parse.quote(artist_key)
        try:
            response = urllib.request.urlopen('https://itunes.apple.com/search?term=' + query + '&entity=musicArtist')
            data = json.loads(response.read())
            print(data)
        except HTTPError as e:
            print('Error code: ', e.code)

    if case_key == '0':
        break
