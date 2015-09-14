var dogController = {};
var Dog = require('../models/dog');

dogController.list = function(req, res) {
  Dog.find(req.query, function(err, list){
    res.json(list);
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
  Dog.findById(req.params.id, function(err, dog){
    res.json(dog);
  });
};

module.exports = dogController;
