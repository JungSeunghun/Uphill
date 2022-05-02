/**
 * 
 */
function openPolicy1() {
	policy1 = document.getElementById("policy1");
	policy1.style.display = 'block';

	policy2 = document.getElementById("policy2");
	policy2.style.display = 'none';
	
	policy3 = document.getElementById("policy3");
	policy3.style.display = 'none';
}

function openPolicy2() {
	policy1 = document.getElementById("policy1");
	policy1.style.display = 'none';
	
	policy2 = document.getElementById("policy2");
	policy2.style.display = 'block';
	
	policy3 = document.getElementById("policy3");
	policy3.style.display = 'none';
}

function openPolicy3() {
	policy1 = document.getElementById("policy1");
	policy1.style.display = 'none';
	
	policy2 = document.getElementById("policy2");
	policy2.style.display = 'none';
	
	policy3 = document.getElementById("policy3");
	policy3.style.display = 'block';
}