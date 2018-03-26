package leetCode;

import java.util.ArrayList;
import java.util.List;

import DataStructure.BiNode;

public class P17LetterCombinationsOfAPhoneNumber {
    static public List<String> letterCombinations(String digits) {
    	PhoneNumber number=null;
    	PhoneNumber firstNumber=null;
    	for(int i=0;i<digits.length();i++){
    		byte digit =(byte) Character.getNumericValue(digits.charAt(i));
    		PhoneNumber oldNumber = number;
    		number = new PhoneNumber(digit);
    		number.initPhoneNumber();
    		if(oldNumber!=null){
    			oldNumber.setPhoneNumberLeftChild(number.getPhoneNumber());
    			oldNumber.updatePhoneNumber();
    		}
    		else{
    			firstNumber=number;
    		}
    		
    	}
    	return PhoneNumber.traverse(firstNumber.getPhoneNumber());
    }
    public static void main(String[] args) {
		String digits = "3624258";
		System.out.println(letterCombinations(digits));
	}
}

class PhoneNumber{
	private byte value;
	private BiNode phoneNumber;
	private BiNode phoneNumberLeftChild;
	
	public PhoneNumber(byte value){
		this.value=value;
	}
	
	public void updatePhoneNumber() {
		// TODO Auto-generated method stub
		phoneNumber.setLeftChild(phoneNumberLeftChild);
		BiNode number = phoneNumber;
		while(null!= number.getRightChild()){
			number=number.getRightChild();
			number.setLeftChild(phoneNumberLeftChild);
		}
	}

	public void initPhoneNumber() {
		switch (this.value) {
		case 2:
	    	phoneNumber = new BiNode('a',phoneNumberLeftChild,new BiNode('b',phoneNumberLeftChild,new BiNode('c',phoneNumberLeftChild,null)));
			break;
		case 3:
			phoneNumber = new BiNode('d',phoneNumberLeftChild,new BiNode('e',phoneNumberLeftChild,new BiNode('f',phoneNumberLeftChild,null)));
			break;
		case 4:
			phoneNumber = new BiNode('g',phoneNumberLeftChild,new BiNode('h',phoneNumberLeftChild,new BiNode('i',phoneNumberLeftChild,null)));
			break;
		case 5:
			phoneNumber = new BiNode('j',phoneNumberLeftChild,new BiNode('k',phoneNumberLeftChild,new BiNode('l',phoneNumberLeftChild,null)));
			break;
		case 6:
			phoneNumber = new BiNode('m',phoneNumberLeftChild,new BiNode('n',phoneNumberLeftChild,new BiNode('o',phoneNumberLeftChild,null)));
			break;
		case 7:
			phoneNumber = new BiNode('p',phoneNumberLeftChild,new BiNode('q',phoneNumberLeftChild,new BiNode('r',phoneNumberLeftChild,new BiNode('s',phoneNumberLeftChild,null))));
			break;
		case 8:
			phoneNumber = new BiNode('t',phoneNumberLeftChild,new BiNode('u',phoneNumberLeftChild,new BiNode('v',phoneNumberLeftChild,null)));
			break;
		case 9:
			phoneNumber = new BiNode('w',phoneNumberLeftChild,new BiNode('x',phoneNumberLeftChild,new BiNode('y',phoneNumberLeftChild,new BiNode('z',phoneNumberLeftChild,null))));
		default:
			break;
		}
    	
	}
	public BiNode getPhoneNumberLeftChild() {
		return phoneNumberLeftChild;
	}
	public void setPhoneNumberLeftChild(BiNode phoneNumberLeftChild) {
		this.phoneNumberLeftChild = phoneNumberLeftChild;
	}
	public BiNode getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(BiNode phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public byte getValue() {
		return value;
	}
	public void setValue(byte value) {
		this.value = value;
	}
	
	public static List<String> traverse(BiNode number){
		List<String> ret = new ArrayList<String>();
		
		List<String> leftChilds=null;
		if(null!=number.getLeftChild())
		{
			leftChilds = traverse(number.getLeftChild());
			for (int i = 0; i < leftChilds.size(); i++) {
				ret.add(number.getValue()+leftChilds.get(i));
			}
		}
		else{
			ret.add(String.valueOf(number.getValue()));
		}
		
		List<String> rightChilds = null;
		if(null!=number.getRightChild()){
			rightChilds = traverse(number.getRightChild());
			ret.addAll(rightChilds);
		}
		
		
		
		return ret;
		
	}
	
}


//BiNode phoneNumber2LeftChild = null;
//BiNode phoneNumber2 = new BiNode('a',phoneNumber2LeftChild,new BiNode('b',phoneNumber2LeftChild,new BiNode('c',phoneNumber2LeftChild,null)));
//BiNode phoneNumber3LeftChild = null;
//BiNode phoneNumber3 = new BiNode('d',phoneNumber3LeftChild,new BiNode('e',phoneNumber3LeftChild,new BiNode('f',phoneNumber3LeftChild,null)));
//BiNode phoneNumber4LeftChild = null;
//BiNode phoneNumber4 = new BiNode('g',phoneNumber4LeftChild,new BiNode('h',phoneNumber4LeftChild,new BiNode('i',phoneNumber4LeftChild,null)));
//BiNode phoneNumber5LeftChild = null;
//BiNode phoneNumber5 = new BiNode('j',phoneNumber5LeftChild,new BiNode('k',phoneNumber5LeftChild,new BiNode('l',phoneNumber5LeftChild,null)));
//BiNode phoneNumber6LeftChild = null;
//BiNode phoneNumber6 = new BiNode('m',phoneNumber6LeftChild,new BiNode('n',phoneNumber6LeftChild,new BiNode('o',phoneNumber6LeftChild,null)));
//BiNode phoneNumber7LeftChild = null;
//BiNode phoneNumber7 = new BiNode('p',phoneNumber7LeftChild,new BiNode('q',phoneNumber7LeftChild,new BiNode('r',phoneNumber7LeftChild,new BiNode('s',phoneNumber7LeftChild,null))));
//BiNode phoneNumber8LeftChild = null;
//BiNode phoneNumber8 = new BiNode('t',phoneNumber8LeftChild,new BiNode('u',phoneNumber8LeftChild,new BiNode('v',phoneNumber8LeftChild,null)));
//BiNode phoneNumber9LeftChild = null;
//BiNode phoneNumber9 = new BiNode('w',phoneNumber9LeftChild,new BiNode('x',phoneNumber9LeftChild,new BiNode('y',phoneNumber9LeftChild,new BiNode('z',phoneNumber9LeftChild,null))));