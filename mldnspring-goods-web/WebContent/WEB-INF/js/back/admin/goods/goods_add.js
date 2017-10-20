window.onload = function() {
	listener("name","blur",validateName) ;
	listener("price","blur",validatePrice) ;
	listener("iid","blur",validateItem) ;
	listener("pic","blur",validatePhoto) ;
	listener("goodsForm","submit",function(e){
		if (validateName() & validatePrice() & validateItem() & validatePhoto() & validateTag()) {
			this.submit() ;
		} else {
			e.preventDefault() ;
		}
	}) ;
}
function validateName() {
	return validateEmpty("name") ;
}
function validatePrice() {
	return validateRegex("price",/\d+(\.\d{1,2})?/) ;
}
function validateItem() { 
	return validateEmpty("iid") ;
}
function validatePhoto() {
	return validateEmpty("pic") ;
}
function validateTag() {
	return validateCheckbox("tid") ;
}