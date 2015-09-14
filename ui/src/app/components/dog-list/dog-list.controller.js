'use strict';
angular.module('ui')
    .controller('DogListCtrl', function ($http, dogService) {
      var self = this;

      dogService.getDogs().then(function(data) {
        self.dogs = data;
      });

      self.remove = function(dog) {
        dogService.remove(dog).then(function() {
          dogService.getDogs().then(function (data) {
            self.dogs = data;
          });
        });
      }

    });