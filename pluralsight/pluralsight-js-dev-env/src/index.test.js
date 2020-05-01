import {expect} from 'chai';
import jsdom from 'jsdom';
import fs from 'fs';

describe('Our first test', () => {
  it("Should pass", () => {
    expect(true).to.equal(true);
  });
});

// describe('index.html', () => {
//   it("Should say hello", (done) => {
//     const index = fs.readFileSync('./src/index.html','utf-8');
//     //jsdom doesn't have all browser features, for example featch is out,
//     //is ncessary to use isomorphic-featch
//     jsdom.env(index, function(err, window){
//       const h1 = window.document.getElementsByTagName('h1')[0];
//       expect(h1.innerHTML).to.equal("Hello World");
//       done();
//       window.close();
//     });
//   });
// });

describe('index.html', () => {
  it("Should have h1 that say Users", (done) => {
    const index = fs.readFileSync('./src/index.html','utf-8');
    //jsdom doesn't have all browser features, for example featch is out,
    //is ncessary to use isomorphic-featch
    jsdom.env(index, function(err, window){
      const h1 = window.document.getElementsByTagName('h1')[0];
      expect(h1.innerHTML).to.equal("Users");
      done();
      window.close();
    });
  });
});

