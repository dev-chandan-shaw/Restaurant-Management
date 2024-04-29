import axios from "axios";
import React, { useEffect, useState } from "react";
import { getMenuItems } from "../../Backend/config";
import { useParams } from "react-router-dom";

const MenuItemCard = () => {
  const [items, setItems] = useState([]);
  const {menutitle} = useParams()

  useEffect(() => {
    fetchMenuItems();
  }, []);

  const fetchMenuItems = async () => {
    const response = await getMenuItems(menutitle);
    setItems(response?.data);
  };

  return (
    <div className="my-10 grid  grid-cols-2 md:grid-cols-4 place-items-center">
      {items?.map((item) => (
        <div
          key={item.id}
          className="md:w-72 border
                  bordder-2 rounded-xl
                  w-40 h-60 md:h-96
                  shadow-md my-5 overflow-hidden"
        >
          <div className="h-4/6 overflow-hidden">
            <img
              src={item.imageUrl}
              className="object-cover w-full h-full w-fullntransform hover:scale-110 transition duration-300"
            />
          </div>
          <div className="h-2/6 flex flex-col justify-evenly px-4 items-center">
            <div className="text-lg md:text-xl text-center font-semibold">
              {item.name}
            </div>

            <div className="flex justify-evenly  w-full">
              <p className="text-lg md:text-xl py-1 text-cente font-semibold">
                Price : ${item.price}
              </p>
              <p className="bg-orange-600 cursor-pointer text-white px-3 py-1 rounded-md font-bold text-center">
                Add+
              </p>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
};

export default MenuItemCard;
