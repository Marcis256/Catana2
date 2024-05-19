import React, { useEffect, useState } from 'react';
import axios from "axios";
import BRICK from "./brick.jpg";
import ORE from "./ore.jpg";
import WOOD from "./wood.jpg";
import SHEEP from "./sheep.jpg";
import GRAIN from "./grain.jpg";
import EMPTY from "./empty.jpg";
import HOUSE from "./house.png";

const sin60 = 2 / Math.sqrt(3);
const r = 100;

const Hex = (props) => {
  const { id, hexId, backgroundImage, diceNumber, onClick, ...divProps } = props;

  return (
    <div
      {...divProps}
      id={id}
      className="hex"
      style={{
        boxSizing: "border-box",
        height: "100px",
        width: "100px",
        ...props.style,
        position: "relative",
        borderRadius: "100%",
        backgroundImage: backgroundImage ? `url(${backgroundImage})` : "none",
        backgroundSize: "cover",
        backgroundPosition: "center",
        cursor: "pointer"
      }}
    >
      {/* Hexagon shape */}
      <div
        style={{
          borderTop: "1px solid #000",
          borderBottom: "1px solid #000",
          boxSizing: "border-box",
          width: 100 / Math.sqrt(3) + "px",
          height: "100%",
          margin: "0 auto",
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
          transform: "rotate(90deg)"
        }}
      />
      <div
        style={{
          borderTop: "1px solid #000",
          borderBottom: "1px solid #000",
          boxSizing: "border-box",
          width: 100 / Math.sqrt(3) + "px",
          height: "100%",
          margin: "0 auto",
          transform: "rotate(150deg)",
          transformOrigin: "center center",
          position: "absolute",
          top: 0,
          left: 0,
          right: 0
        }}
      />
      <div
        style={{
          borderTop: "1px solid #000",
          borderBottom: "1px solid #000",
          boxSizing: "border-box",
          width: 100 / Math.sqrt(3) + "px",
          height: "100%",
          margin: "0 auto",
          transform: "rotate(210deg)",
          transformOrigin: "center center",
          position: "absolute",
          top: 0,
          left: 0,
          right: 0
        }}
      />

      {/* Circle in the middle with text of diceNumber */}
      <div
        style={{
          width: "40px",
          height: "40px",
          borderRadius: "50%",
          backgroundColor: "#FFF",
          position: "absolute",
          top: "50%",
          left: "50%",
          transform: "translate(-50%, -50%)",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          fontSize: "14px",
          color: "#000"
        }}
      >
        {diceNumber}
      </div>
    </div>
  );
};

const Board = () => {
  const [board, setBoard] = useState([]);
  const [player, setPlayer] = useState([]);
  const [dots, setDots] = useState([]);
  const [settlement, setSettlement] = useState([]);
  const [dotPosition, setDotPosition] = useState({ top: "50%", left: "50%" }); // Default position

  const handleDotClick2 = (dotId) => {
    alert(`Dot ID: ${dotId}`);
  };

  useEffect(() => {
    loadBoardData();
    generateDots();
    loadSettlementData();
  }, []);

  const loadBoardData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/v1/board");
      if (!response.data || !Array.isArray(response.data)) {
        throw new Error("Invalid board data format");
      }
      setBoard(response.data);
    } catch (error) {
      console.error("Error loading board data:", error);
      setBoard([]);
    }
  };

  const loadPlayerData = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/v1/players");
      if (!response.data || !Array.isArray(response.data)) {
        throw new Error("Invalid player data format");
      }
      setPlayer(response.data);
    } catch (error) {
      console.error("Error loading player data:", error);
      setPlayer([]);
    }
  };

const handleDotClick = async (dotId) => {
  try {
    const settlementName = `settlement_${dotId}`; // Convert dotId to string explicitly
    const playerId = 1; // Assuming you have the player ID stored somewhere
    const response = await axios.put(`http://localhost:8080/api/v1/players/${playerId}/addSettlement`, JSON.stringify(settlementName), {
      headers: {
        'Content-Type': 'application/json'
      }
    });
    if (response.status === 200) {
      // Update the state to reflect the changes
      console.log("Settlement added successfully!");
    } else {
      console.error("Failed to add settlement:", response.data);
    }
  } catch (error) {
    console.error("Error adding settlement:", error);
  }
};

  const loadSettlementData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/v1/settlement-places");
        if (!response.data || !Array.isArray(response.data)) {
          throw new Error("Invalid player data format");
        }
        setSettlement(response.data);
      } catch (error) {
        console.error("Error loading player data:", error);
        setSettlement([]);
      }
    };

const generateDots = () => {
  // Generating 54 black dots with different IDs
  const newDots = Array.from({ length: 54 }, (_, index) => {
    let position;
    if (index === 0) {
      position = { top: "-2%", left: "39.4%" };
    } else if (index === 1) {
      position = { top: "-2%", left: "49.4%" };
    } else if (index === 2) {
       position = { top: "-2%", left: "59.4%" };
    } else if (index === 3) {
         position = { top: "3%", left: "34.5%" };
    } else if (index === 4) {
         position = { top: "3%", left: "44.4%" };
    } else if (index === 5) {
         position = { top: "3%", left: "54.4%" };
    } else if (index === 6) {
         position = { top: "3%", left: "64.4%" };
    } else if (index === 7) {
         position = { top: "13%", left: "34.4%" };
    } else if (index === 8) {
         position = { top: "13%", left: "44.4%" };
    } else if (index === 9) {
         position = { top: "13%", left: "54.4%" };
    } else if (index === 10) {
         position = { top: "13%", left: "64.4%" };
    } else if (index === 11) {
         position = { top: "18%", left: "29.5%" };
    } else if (index === 12) {
         position = { top: "18%", left: "39.5%" };
    } else if (index === 13) {
         position = { top: "18%", left: "49.5%" };
    } else if (index === 14) {
         position = { top: "18%", left: "59.5%" };
    } else if (index === 15) {
         position = { top: "18%", left: "69.5%" };
    } else if (index === 16) {
         position = { top: "28.5%", left: "29.5%" };
    } else if (index === 17) {
         position = { top: "28.5%", left: "39.5%" };
    } else if (index === 18) {
         position = { top: "28.5%", left: "49.5%" };
    } else if (index === 19) {
         position = { top: "28.5%", left: "59.5%" };
    } else if (index === 20) {
         position = { top: "28.5%", left: "69.5%" };
    } else if (index === 21) {
         position = { top: "33%", left: "24.5%" };
    } else if (index === 22) {
         position = { top: "33%", left: "34.5%" };
    } else if (index === 23) {
         position = { top: "33%", left: "44.5%" };
    } else if (index === 24) {
         position = { top: "33%", left: "54.5%" };
    } else if (index === 25) {
         position = { top: "33%", left: "64.5%" };
    } else if (index === 26) {
         position = { top: "33%", left: "74.5%" };
    } else if (index === 27) {
         position = { top: "43.5%", left: "24.5%" };
    } else if (index === 28) {
         position = { top: "43.5%", left: "34.5%" };
    } else if (index === 29) {
         position = { top: "43.5%", left: "44.5%" };
    } else if (index === 30) {
         position = { top: "43.5%", left: "54.5%" };
    } else if (index === 31) {
         position = { top: "43.5%", left: "64.5%" };
    } else if (index === 32) {
         position = { top: "43.5%", left: "74.5%" };
    } else if (index === 33) {
         position = { top: "48.5%", left: "29.5%" };
    } else if (index === 34) {
         position = { top: "48.5%", left: "39.5%" };
    } else if (index === 35) {
         position = { top: "48.5%", left: "49.5%" };
    } else if (index === 36) {
         position = { top: "48.5%", left: "59.5%" };
    } else if (index === 37) {
         position = { top: "48.5%", left: "69.5%" };
    } else if (index === 38) {
         position = { top: "59%", left: "29.5%" };
    } else if (index === 39) {
         position = { top: "59%", left: "39.5%" };
    } else if (index === 40) {
         position = { top: "59%", left: "49.5%" };
    } else if (index === 41) {
         position = { top: "59%", left: "59.5%" };
    } else if (index === 42) {
         position = { top: "59%", left: "69.5%" };
    } else if (index === 43) {
         position = { top: "64%", left: "34.5%" };
    } else if (index === 44) {
         position = { top: "64%", left: "44.5%" };
    } else if (index === 45) {
         position = { top: "64%", left: "54.5%" };
    } else if (index === 46) {
         position = { top: "64%", left: "64.5%" };
    } else if (index === 47) {
         position = { top: "74.5%", left: "34.5%" };
    } else if (index === 48) {
         position = { top: "74.5%", left: "44.5%" };
    } else if (index === 49) {
         position = { top: "74.5%", left: "54.5%" };
    } else if (index === 50) {
         position = { top: "74.5%", left: "64.5%" };
    } else if (index === 51) {
         position = { top: "79.5%", left: "39.5%" };
    } else if (index === 52) {
         position = { top: "79.5%", left: "49.5%" };
    } else if (index === 53) {
         position = { top: "79.5%", left: "59.5%" };
    } else {
      position = getRandomPosition(); // Random position for other dots
    }
    return {
      id: `${index + 1}`,
      position: position,
    };
  });
  setDots(newDots);
};

  const getRandomPosition = () => {
    // Function to generate random position values
    const position = {
      top: Math.floor(Math.random() * 80) + 10 + "%",
      left: Math.floor(Math.random() * 80) + 10 + "%",
    };
    return position;
  };

  const handleHexClick = (id) => {
    //alert(`Hexagon ID: ${id}`);
  };

  const handleDotPositionChange = (event) => {
    const { name, value } = event.target;
    setDotPosition((prevPosition) => ({
      ...prevPosition,
      [name]: value,
    }));
  };

  const createBoard = () => {
    const rowLengthList = [3, 4, 5, 4, 3];
    let tileCounter = 1; // Initialize the tile counter

    return rowLengthList.map((length, rowIndex) =>
      Array.from({ length }, (_, cellIndex) => `TILE_${tileCounter++}`)
    );
  };

  useEffect(() => {
    loadPlayerData();
  }, []);

  const changeDotPosition = (newPosition) => {
    // Change the position of the dot with ID 1
    const updatedDots = dots.map((dot) =>
      dot.id === 'dot-1' ? { ...dot, position: newPosition } : dot
    );
    setDots(updatedDots);
  };

  return (
    <div className="App" style={{ width: "1000px", marginTop: "35px", position: "relative" }}>
      <div>
        {createBoard().map((row, rowIndex) => (
          <div
            key={rowIndex}
            id={`hex-row-${rowIndex}`} // Assign unique ID to the row
            style={{
              marginTop: "-14px",
              display: "flex",
              justifyContent: "center"
            }}
          >
            {row.map((_, cellIndex) => {
              // Check if the current cellIndex is within the bounds of the board array
              if (cellIndex < board.length) {
                let i = cellIndex;
                if (rowIndex === 1) {
                  i = cellIndex + 3;
                } else if (rowIndex === 2) {
                  i = cellIndex + 7;
                } else if (rowIndex === 3) {
                  i = cellIndex + 12;
                } else if (rowIndex === 4) {
                  i = cellIndex + 16;
                }

                const hexData = board[i]; // Get the data for the current hex
                let backgroundImage;

                switch (hexData.tileType) {
                  case "BRICK":
                    backgroundImage = BRICK;
                    break;
                  case "ORE":
                    backgroundImage = ORE;
                    break;
                  case "WOOD":
                    backgroundImage = WOOD;
                    break;
                  case "SHEEP":
                    backgroundImage = SHEEP;
                    break;
                  case "GRAIN":
                    backgroundImage = GRAIN;
                    break;
                  case "EMPTY":
                    backgroundImage = EMPTY;
                    break;
                  default:
                    backgroundImage = null;
                }
                return (
                  <Hex
                    key={`${hexData.id}`} // Unique key for each Hex component
                    id={`${hexData.id}`} // Assign unique ID to each hexagon
                    backgroundImage={backgroundImage} // Pass background image URL as a prop
                    style={{ height: `${r}px`, width: `${r}px` }}
                    diceNumber={hexData.diceNumber} // Pass the diceNumber from the API response
                    onClick={handleHexClick} // Pass the function to handle click event
                  />
                );
              } else {
                // If cellIndex exceeds the length of the board array, render an empty div
                return <div key={`empty-${cellIndex}`} style={{ width: `${r}px` }} />;
              }
            })}
          </div>
        ))}
      </div>
      <div>
        <table style={{ width: "500px", marginTop: "40px" }}>
          <thead>
            <tr>
              <th></th>
              <th>ORE</th>
              <th>BRICK</th>
              <th>WOOD</th>
              <th>GRAIN</th>
              <th>SHEEP</th>
            </tr>
          </thead>
          <tbody>
            {player.map((players, playerIndex) => (
              <tr key={playerIndex}>
                <th>{players.name}</th>
                <td>{players.cards.ore}</td>
                <td>{players.cards.brick}</td>
                <td>{players.cards.wood}</td>
                <td>{players.cards.grain}</td>
                <td>{players.cards.ore}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Rendering black dots */}
{dots.map((dot) => (
  <div
    key={dot.id} // Assign a unique key using the dot's ID
    id={dot.id}
    style={{
      position: "absolute",
      width: "10px",
      height: "10px",
      backgroundColor: dot.id === '30' ? 'transparent' : '#000',
      borderRadius: "50%",
      top: dot.position.top,
      left: dot.position.left,
      cursor: "pointer",
    }}
    onClick={() => handleDotClick(dot.id)}
  >
    {/* Render image for dot 5 */}
    {settlement.map((settlements, settlementIndex) => (
      settlements && settlements.substring(11) === dot.id && (
        <div
          key={`settlement-${settlementIndex}`} // Assign a unique key to the nested div
          style={{
            position: "absolute",
            top: "50%",
            left: "50%",
            transform: "translate(-450%, -50%)",
          }}
        >
          <img
            src={HOUSE}
            alt="Dot"
            style={{
              width: "1000%",
              height: "1000%",
              borderRadius: "50%",
              objectFit: "cover",
            }}
          />
        </div>
      )
    ))}
  </div>
))}
    </div>
  );
};

export default Board;
