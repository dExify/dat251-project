import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getAuthStatus, logout } from "./auth";
import logo from "./assets/gg.png";
import "./you.css";
import "./App.css";

export default function You() {
  const navigate = useNavigate();
  const [authData, setAuthData] = useState(null);

  useEffect(() => {
    async function assertLoggedIn() {
      try {
        const { ok, data } = await getAuthStatus();
        if (!ok || !data.authenticated) {
          navigate("/login", { replace: true });
        }
        setAuthData(data);
      } catch {
        navigate("/login", { replace: true });
      }
    }

    assertLoggedIn();
  }, [navigate]);

  async function handleLogout() {
    try {
      await logout();
    } finally {
      navigate("/", { replace: true });
    }
  }

  return (
    <div className="you-page">
      <header className="you-topbar">
        <div className="you-brand-block">
          <img src={logo} alt="Greengafl logo" className="you-brand-logo" />
        </div>

        <nav className="you-auth-actions" aria-label="Authentication">
          <button type="button" className="ghost-button" onClick={handleLogout}>
            Log out
          </button>
        </nav>
      </header>

      <main className="you-content">
        <h1>hello, world!</h1>
        <p>Logged in as {authData?.username}</p>
      </main>
    </div>
  );
}
