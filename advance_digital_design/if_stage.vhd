----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:59:41 11/13/2009 
-- Design Name: 
-- Module Name:    if_stage - Behavioral 
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

entity if_stage is
    Port ( clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           ins_out : out  STD_LOGIC_VECTOR (31 downto 0));
end if_stage;

architecture Behavioral of if_stage is

component memory is
    Port ( clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
			  mre : in  STD_LOGIC;
           mwe : in  STD_LOGIC;
			  addr : in  STD_LOGIC_VECTOR (7 downto 0);
           inst_in : in  STD_LOGIC_VECTOR (31 downto 0);
           inst_out : out  STD_LOGIC_VECTOR (31 downto 0));
end component;

component pc is
    Port ( clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           pc_in : in  STD_LOGIC_VECTOR (7 downto 0);
           pc_out : out  STD_LOGIC_VECTOR (7 downto 0));
end component;

signal pc2im:STD_LOGIC_VECTOR (7 downto 0);

begin

--im:for i in 0 to 2 generate

--write:if i=0 generate
im_write:memory port map(clk,rst,'0','1',"00000000","00000000000000000000000000000000",ins_out);
--end generate write;
--
--read:if i>0 generate

pcc:pc port map(clk,rst,"00000000",pc2im);
im_re:memory port map(clk,rst,'1','0',"00000000","00000000000000000000000000000000",ins_out);
--ins_out<=pc2im;
--pc2im<=pc2im+4;

--end generate read;
--end generate im;

end Behavioral;