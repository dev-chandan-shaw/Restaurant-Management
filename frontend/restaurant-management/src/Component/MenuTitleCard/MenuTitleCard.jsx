import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { login } from "../../Store/authSlice";
import { getMenuTitles } from "../../Backend/config";

const MenuTitleCard = () => {
  const [menuTitles, setMenuTitles] = useState([]);
  const navigate = useNavigate();

  const fetchMenuTitles = async () => {
    
    try {
      const response = await getMenuTitles();
      setMenuTitles(response.data);
      navigate("/")
    } catch (error) {
      console.log("something went wrong");
      navigate("/login")
    }
    
  };
  useEffect(() => {
    fetchMenuTitles();
  }, []);

  return (
    <div className="my-10 grid  grid-cols-2 md:grid-cols-4 place-items-center">
      {menuTitles.map((menuTitle) => (
        <Link
          key={menuTitle.id}
          to={`/${menuTitle.title
            .toLowerCase()
            .split(" ")
            .join("-")}/menu-items`}
          className="md:w-72 border
                    bordder-2 rounded-xl
                    w-40 h-60 md:h-96
                    shadow-md my-5 overflow-hidden"
        >
          <div className="h-4/6 overflow-hidden">
            <img
              src={menuTitle.imageUrl}
              className="object-cover w-full h-full w-fullntransform hover:scale-110 transition duration-300"
            />
          </div>
          <div className="h-2/6 flex justify-center items-center">
            <p className="text-lg md:text-2xl font-bold text-center">
              {menuTitle.title}
            </p>
          </div>
        </Link>
      ))}
    </div>
  );
};

export default MenuTitleCard;
