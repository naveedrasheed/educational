----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:43:10 01/12/2010 
-- Design Name: 
-- Module Name:    tb - Behavioral 
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

entity id_stage is
    Port ( 
				clock,reset : in  STD_LOGIC;
				inst : in  STD_LOGIC_VECTOR (31 downto 0);
           data : in  STD_LOGIC_VECTOR (31 downto 0);
           wr_en : in  STD_LOGIC;
           rd1 : out  STD_LOGIC_VECTOR (31 downto 0);
           rd2 : out  STD_LOGIC_VECTOR (31 downto 0);
           offset : out  STD_LOGIC_VECTOR (31 downto 0));
end id_stage;

architecture Behavioral of id_stage is

component reg_f is
	generic(width:natural:=32);
    Port ( clock,reset : in  STD_LOGIC;
           data : in  STD_LOGIC_VECTOR (width-1 downto 0);
           wr_en : in  STD_LOGIC;
           w_add : in  STD_LOGIC_VECTOR (4 downto 0);
           a_add : in  STD_LOGIC_VECTOR (4 downto 0);
           b_add : in  STD_LOGIC_VECTOR (4 downto 0);
           a : out  STD_LOGIC_VECTOR (width-1 downto 0);
           b : out  STD_LOGIC_VECTOR (width-1 downto 0));
end component;

begin

regg:reg_f generic map(32) port map(clock,reset,data,wr_en,inst(25 downto 21),inst(20 downto 16),inst(15 downto 11),rd1,rd2);

offset<="0000000000000000" & inst(15 downto 0);
end Behavioral;

