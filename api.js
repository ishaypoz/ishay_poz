
const fetch = require('node-fetch');
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  })
// node api.js 
readline.question("Please choose a number (1,2,3,4) \n 1. /Search \n 2. /Search with more than 1 key \n 3. Get Albums 1 and more \n 4. Get Artist 1 and more \n", (caseKey) => {
    // get input caseKey(as string) to the switch case using the readLine module
    switch(caseKey) {
    case '1':
        readline.question("iTunes Search: ", (searchKey) => {
            // make the url for the itunes API search
            var url = 'https://itunes.apple.com/search?term='+encodeURIComponent(searchKey);
            /* fetch the url using node-fetch package get the data as JSON 
            link: https://www.npmjs.com/package/node-fetch */
            fetch(url)
            .then(res => res.json())
            .then((out) => {
        console.log('Output: ', out);
        }).catch(err => console.error(err));
        })
        break;
    case '2':
        readline.question("iTunes Search: ", (searchKey) => {
            readline.question("Limit result to: ", (limitKey) => {
            var url = `https://itunes.apple.com/search?term=${encodeURIComponent(searchKey)}&limit=${encodeURIComponent(limitKey)}`;
            console.log(url);
                fetch(url)
                .then(res => res.json())
                .then((out) => {
            console.log('Output: ', out);
            }).catch(err => console.error(err));
            })
        })
        break;
    case '3':
        readline.question("iTunes Albums Search: ", (albumKey) => {
            var url = `https://itunes.apple.com/search?term=${encodeURIComponent(albumKey)}&entity=album`;
            fetch(url)
            .then(res => res.json())
            .then((out) => {
        console.log('Output: ', out);
        }).catch(err => console.error(err));
        })
        break;
    case '4':
        readline.question("iTunes Artists Search: ", (artistKey) => {
            var url = `https://itunes.apple.com/search?term=${encodeURIComponent(artistKey)}&entity=musicArtist`;
            fetch(url)
            .then(res => res.json())
            .then((out) => {
        console.log('Output: ', out);
        }).catch(err => console.error(err));
        })
        break;
    default:
        break;
    }
})
