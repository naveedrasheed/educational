----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:27:46 01/12/2010 
-- Design Name: 
-- Module Name:    data_path - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

---- Uncomment the following library declaration if instantiating
---- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity data_path is
    Port ( clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           pc_src : in  STD_LOGIC;
           alu_src: in STD_LOGIC_VECTOR (1 downto 0);
           alu_op : in  STD_LOGIC_VECTOR (1 downto 0);
           mem_rd : in  STD_LOGIC;
           mem_wt : in  STD_LOGIC;
           mem2reg : in  STD_LOGIC;
           reg_wt : in  STD_LOGIC;
			  pce :in  STD_LOGIC;
			  addr : in  STD_LOGIC_VECTOR (7 downto 0);
			  data : in  STD_LOGIC_VECTOR (31 downto 0);
			  O : out  STD_LOGIC_VECTOR (31 downto 0));
end data_path;

architecture Behavioral of data_path is

component if_stage is
    Port ( 
				addr : in  STD_LOGIC_VECTOR (7 downto 0);
           inst_in : in  STD_LOGIC_VECTOR (31 downto 0);
           mre : in  STD_LOGIC;
           mwe : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
			  pce: in  STD_LOGIC;
			  
				pc_p_4 : in  STD_LOGIC_VECTOR (7 downto 0);
           inst_out : out  STD_LOGIC_VECTOR (31 downto 0);
           nxt_pc : out  STD_LOGIC_VECTOR (7 downto 0));
end component ;

component id_stage is
    Port ( 
				clock,reset : in  STD_LOGIC;
				inst : in  STD_LOGIC_VECTOR (31 downto 0);
           data : in  STD_LOGIC_VECTOR (31 downto 0);
           wr_en : in  STD_LOGIC;
           rd1 : out  STD_LOGIC_VECTOR (31 downto 0);
           rd2 : out  STD_LOGIC_VECTOR (31 downto 0);
           offset : out  STD_LOGIC_VECTOR (31 downto 0));
end component ;

component ex_stage is
    Port ( a : in  STD_LOGIC_VECTOR (31 downto 0);
           b : in  STD_LOGIC_VECTOR (31 downto 0);
           c : in  STD_LOGIC_VECTOR (31 downto 0);
			  alu_op: in STD_LOGIC_VECTOR (1 downto 0);
			  alu_src: in STD_LOGIC_VECTOR (1 downto 0);
           alu_out : out  STD_LOGIC_VECTOR (31 downto 0);
           reg_out : out  STD_LOGIC_VECTOR (31 downto 0));
end component ;

component mem_acc is
    Port ( addr : in  STD_LOGIC_VECTOR (7 downto 0);
           data : in  STD_LOGIC_VECTOR (31 downto 0);
           mre : in  STD_LOGIC;
           mwe : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           data_out : out  STD_LOGIC_VECTOR (31 downto 0));
end component ;

component wb_stage is
    Port ( mem2reg: in STD_LOGIC;
				mem_out : in  STD_LOGIC_VECTOR (31 downto 0);
           alu_out : in  STD_LOGIC_VECTOR (31 downto 0);
           data_out : out  STD_LOGIC_VECTOR (31 downto 0));
end component ;

signal pc_plus_4:STD_LOGIC_VECTOR (7 downto 0):="00000000";
signal instruction:STD_LOGIC_VECTOR (31 downto 0);
signal reg1:STD_LOGIC_VECTOR (31 downto 0);
signal reg2:STD_LOGIC_VECTOR (31 downto 0);
signal offset_address:STD_LOGIC_VECTOR (31 downto 0);
signal alu_output:STD_LOGIC_VECTOR (31 downto 0);
signal reg_output:STD_LOGIC_VECTOR (31 downto 0);
signal mem_out:STD_LOGIC_VECTOR (31 downto 0);
signal data_out:STD_LOGIC_VECTOR (31 downto 0);

begin

if_s:if_stage port map(addr,data ,mem_rd ,not mem_rd ,clk ,rst , pce,pc_plus_4,instruction ,pc_plus_4 );
id_s:id_stage port map(clk,rst ,instruction ,data_out ,reg_wt ,reg1 ,reg2,offset_address);
exe_s:ex_stage port map( reg1,reg2,offset_address,alu_op,alu_src,alu_output,reg_output);
mem_acc_s:mem_acc port map(addr,alu_output,mem_rd,not mem_rd,clk,rst,mem_out);
wb_s:wb_stage port map( mem2reg,mem_out,alu_output,data_out);
O<=data_out;
end Behavioral;

