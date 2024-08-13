`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    11:14:45 05/07/2009 
// Design Name: 
// Module Name:    memory 
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
module memory(read,write,pc,data_in,data_out,clk);

input clk;
input read;
input write;
input [31:0]data_in;
input [31:0]pc;

reg[31:0]main_memory[0:1023];
output [31:0]data_out;
reg [31:0]data_out;


always@(posedge clk)
begin

if(read==1)
begin
data_out=main_memory[pc];
end

if(write==1)
begin
main_memory[pc]=data_in;
end



end
endmodule
