/* global require, module */
var EmberApp = require('ember-cli/lib/broccoli/ember-app');

module.exports = function(defaults) {
  var app = new EmberApp(defaults, {
    // Add options here
  });

  app.import(app.bowerDirectory + '/bootstrap/dist/js/bootstrap.min.js');
  app.import(app.bowerDirectory + '/bootstrap/dist/css/bootstrap.min.css');
  app.import(app.bowerDirectory + '/bootstrap/dist/fonts/glyphicons-halflings-regular.woff', {
      destDir: 'fonts'
  });
  app.import(app.bowerDirectory + '/bootstrap/dist/fonts/glyphicons-halflings-regular.woff2', {
      destDir: 'fonts'
  });

  return app.toTree();
};
