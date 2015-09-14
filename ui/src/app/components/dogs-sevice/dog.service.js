'use strict';

angular
    .module('ui')
    .service('dogService', function ($http) {

      return {
        getDogs: function() {
          return $http.get('http://localhost:4000/dogs').then(function (response) {
            return response.data;
          });
        },

        remove: function(dog) {
          return $http.delete('http://localhost:4000/dogs/' + dog._id, dog).then(function (response) {
            return response.data;
          });
        }
      };

    });