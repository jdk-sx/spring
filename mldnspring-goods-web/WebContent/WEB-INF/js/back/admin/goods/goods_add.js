window.onload = function() {
	listener("name","blur",validateName) ;
	listener("price","blur",validatePrice) ;
	listener("item","blur",validateItem) ;
	listener("photo","blur",validatePhoto) ;
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
	return validateEmpty("item") ;
}
function validatePhoto() {
	return validateEmpty("photo") ;
}
function validateTag() {
	return validateCheckbox("tag") ;
}