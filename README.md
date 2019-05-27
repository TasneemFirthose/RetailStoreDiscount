# RetailDiscount

# Tested in Postman Rest Client 
 
# sample request api:

#  http://localhost:8080/retail/netAmount/
 
# input data:
 
 {
“ userType”:” employee” 
 “amount”: “500” 
 :years”: “3”
“ item_type”: “clothing”
} 

 
# functionality:
 
 discount_amount= 500*(30/100); 
 net_amount= 500-150; 
 net_amount= 350
  
#  if(net_amount>=100) 
   
   if(350>=100)
   {
     discout_amount= 350*(5/100);
     net_amount= 350- 17.5
#  Sample response 
net_amount:332.5
