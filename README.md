# re-cix

### Running the App

```sh
npm install
npx shadow-cljs watch app
```

Please be patient; it may take over 20 seconds to see any output, and over 40 seconds to complete.

When `[:app] Build completed` appears in the output, browse to
[http://localhost:8280/](http://localhost:8280/).

### Development

```sh
npm install
npm run watch
```

Then in another terminal:
```sh
karma start
```

### Production

Build the app with the `prod` profile:

```sh
npm install
npm run release
```
