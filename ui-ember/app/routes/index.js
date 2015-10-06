import Ember from 'ember';
import ajax from 'ic-ajax';

export default Ember.Route.extend({
  model: function() {
    return Ember.RSVP.hash({
      dogs: Ember.$.ajax({
        url: 'http://localhost:4000/dogs'
      })
    });
  }
});
