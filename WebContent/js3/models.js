var rootURL = "http://localhost:8080/Motorbikes/rest/motors";
var Motor = Backbone.Model.extend({
	urlRoot:rootURL,
	defaults:{ 
	    "id": null,
	    "make": "default",
	    "year": "default",
	    "mileage": "default",
	    "colour": "default",
	    "engine": "default",
	    "description": "default",
	    "picture": "default"},
  initialize: function(){
    this.on('change', function(){
    	console.log('呼哈哈');
    });
  }
});


var MotorList = Backbone.Collection.extend({
	model: Motor,
	url:rootURL});
 


