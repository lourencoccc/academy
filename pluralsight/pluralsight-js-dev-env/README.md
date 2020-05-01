# pluralsight-js-dev-env
Course Buiilding a JavaScript Development Environment from Pluralsight

## Editor and Congfiguration

Front-end: Atom or VSCode
Back-end: IDEA or Eclipse

Use editor congfiguration project: http://editorconfig.org/

## Package Management

Use NPM, https://www.npmjs.com/

Chek security vunerability with [Node Security Plataform](https://nodesecurity.io) and [Retire.js](https://github.com/retirejs/retire.js/)

    npm install nsp --global
    npm install retire --global

Runing check

    nsp check
    retire

More details about security library, [OWSP](https://www.owasp.org): https://www.owasp.org/index.php/Top_10_2013-A9-Using_Components_with_Known_Vulnerabilities

## Development Web Server

HTTP Server Frameworks

1. [Express](http://expressjs.com) - most popular and powerful
2. [Hapi](https://hapijs.com/) - similar to express
3. [KOA](http://koajs.com/) - similar express, but more focus on ES2015 and node v7 above

Sharing work-in-progressnpm-run-all

* [Localtunnel](https://localtunnel.github.io/www/) - Easily share work on your local machine
* [Ngrok](https://ngrok.com/) - Secure tunel on your local machine
* [Now](https://zeit.co/now) - Quickly deploy NodeJs to the cloud.
* [Surge](https://surge.sh/) - Quickly host static files to public url.

[localtunnel](https://localtunnel.github.io/www/)
    1. mpm install localtunnel -g
    2. Start your app
    3. lt --port 3000 --subdomain lourc

## Automation

Use [NPM scripts](https://docs.npmjs.com/misc/scripts) and
see [npm-run-all](https://www.npmjs.com/package/npm-run-all)

## Transpiling

Options:

1. Babel
    * Experimental features
    * Transpiling build scripts
2. TypeScript
3. Elm

**Babel** is preferred

## Bundling

Why Use ES6 Modules?

* Standardized
* Statically analyzable
    * Improved autocomplete
    * Intelligent refactoring
    * Fails fast
    * Tree shaking
* Easy to read
    * Named imports
    * Default exports

Choosing a Bundler

Options:

* Browserify
* Webpack
* Rollup
* JSPM

**Webpack 2** is preferred

## Linting

* JSLint
* JSHin
* Eslint

**Eslint** is preferred

## Testimg smd Continuous Integration

Unit Testing Decisions

1. Framework
    * **Mocha**, is recommended by course, but the others are best to.
    * Jasmine
    * Jest
2. Assertion Library
    * **Chai.js** because Mocha doesn't support by default, http://chaijs.com/
3. Helper Libraries
    * Cheerio, like from jquery
    * **JSDOM** is preferred, https://github.com/tmpvar/jsdom
4. Where to run tests
    * Browser
        * Karma, Testem
    * Headless Browser
        * PhatomJS
    * In-memory DOM
        * **Node** and **JSDOM**, is the best choice.
5. Where to place tests
    * Centralized
        * Less "noise" in src folder
        * Deployment confusion
        * Inertia
    * **Alongside**, is the best choice
        * Easy imports
        * Clear visibility
        * Convenient to open
        * No recreating folder structure
        * Easy file moves
6. When to run tests
    * **Upon save**
        * Unit test is very fast, integration test is slow

## Project Structure

## Production Build

### Error Logging

    * TrackJS


## Production Deploy

Why separete the UI and API?

1. Simple, low-risk, UI only deploys
2. Separetes concerns
    * Separte teams
    * Less to understend
    * Scale back-end separately
3. Cheap UI hosting
4. Serve UI via a Content Delivery Network (CDN)
5. Use the API tech you like (Java, C#, Ruby, Python, C/C++, ...)

Cloud Hosting

* AWS
* Azure
* Heroku
* Firebase
* Google Cloud
* Netlify
* GitHub Pages
* Surge

**Netlify, GitHub Pages and Suge, has focus on serving only static files**

