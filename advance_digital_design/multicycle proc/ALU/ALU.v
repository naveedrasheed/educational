`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    12:17:26 05/07/2009 
// Design Name: 
// Module Name:    ALU 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module ALU(clk,alu_scrA,alu_scrB,aluctrl,alu_result,zero);

input clk;
input [31:0]alu_scrA;
input [31:0]alu_scrB;
input [1:0]aluctrl;

output [31:0]alu_result;
output zero;
reg [31:0]alu_result;
reg zero;
parameter add=2'b00;
parameter sub=2'b01;
parameter orr=2'b10;
parameter andd=2'b11;



always@(posedge clk)
begin
case(aluctrl)

add:
begin
alu_result<=alu_scrA + alu_scrB;
if(alu_result==0)
zero<=alu_result;
end


sub:
begin
alu_result<=alu_scrA - alu_scrB;
if(alu_result==0)
zero<=alu_result;
end


orr:
begin
alu_result<=alu_scrA || alu_scrB;
if(alu_result==0)
zero<=alu_result;
end


andd:
begin
alu_result<= alu_scrA && alu_scrB;
if(alu_result==00)
zero<=alu_result;
end


endcase
end
endmodule
