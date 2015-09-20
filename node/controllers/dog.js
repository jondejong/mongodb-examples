var dogController = {};
var Dog = require('../models/dog');
var _ = require('lodash')

function cleanIds(data) {
  var dog = data.toObject();
  dog.id = dog._id
  dog._id = undefined;
  return dog;
}

dogController.list = function(req, res) {
  Dog.find(req.query, function(err, list){
    var i = 0;
    var dogs = _.collect(list, function(data) {
      return cleanIds(data)
    });

    res.json(dogs);
  });

};

dogController.update = function(req, res) {
  var doUpdate = function (dog) {
    dog.name = req.body.name;
    dog.breed = req.body.breed;
    dog.age = req.body.age;

    dog.save(function(err) {
      res.json({
        message: dog.name + ' has been updated.'
      });
    });
  };

  Dog.findById(req.params.id, function(err, dog){
    doUpdate(dog);
  });
};

dogController.delete = function(req,res) {
  Dog.findById(req.params.id, function(err, dog) {
    dog.remove(function() {
      res.json({
            message: 'Dog has been removed'
          });
    });
  });
};

dogController.save = function(req, res) {
  var dog = new Dog();
  dog.name = req.body.name;
  dog.breed = req.body.breed;
  dog.age = req.body.age;

  dog.save(function(err) {
    res.json({
        message: dog.name + ' has been added.'
      });
  });
};

dogController.get = function(req, res) {
  Dog.findById(req.params.id, function(err, data){
    res.json(cleanIds(data));
  });
};

module.exports = dogController;
