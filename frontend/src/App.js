import './App.css';

const featureCards = [
  {
    title: 'Personalize suggestions',
    description:
      'Set dietary needs, ingredient preferences, cooking time, and difficulty to shape better dinner ideas.',
  },
  {
    title: 'Get suggestions fast',
    description:
      'Jump straight to a curated list of dinner options when you need an answer quickly after a long day.',
  },
  {
    title: 'Built to learn your taste',
    description:
      'Liked dinners can later help Greengafl improve what it recommends and keep ideas feeling fresh.',
  },
];

function App() {
  return (
    <div className="landing-page">
      <div className="page-glow page-glow-left" aria-hidden="true" />
      <div className="page-glow page-glow-right" aria-hidden="true" />

      <header className="topbar">
        <div>
          <p className="brand-mark">Greengafl</p>
          <p className="brand-subtitle">Easy dinner suggestions with room to personalize.</p>
        </div>

        <nav className="auth-actions" aria-label="Authentication">
          <button type="button" className="ghost-button">
            Log in
          </button>
          <button type="button" className="primary-button">
            Register
          </button>
        </nav>
      </header>

      <main className="hero-layout">
        <section className="hero-copy">
          <p className="eyebrow">Dinner inspiration, made practical</p>
          <h1>Find a dinner you actually want to cook tonight.</h1>
          <p className="hero-text">
            Greengafl helps users discover meal ideas based on dietary preferences,
            restrictions, cooking difficulty, and available time. It starts simple, then
            grows into a smarter way to choose dinner.
          </p>

          <div className="hero-actions">
            <button type="button" className="primary-button large-button">
              Register
            </button>
            <button type="button" className="ghost-button large-button">
              Log in
            </button>
          </div>

          <div className="secondary-actions">
            <button type="button" className="feature-link">
              Personalize suggestions
            </button>
            <button type="button" className="feature-link">
              Get suggestions
            </button>
          </div>
        </section>

        <section className="visual-panel" aria-label="App preview">
          <div className="visual-card visual-card-main">
            <p className="visual-label">Coming next</p>
            <h2>App preview space</h2>
            <p>
              This area can later hold food photography, featured dishes, or a collage that
              gives the front page more appetite and personality.
            </p>
          </div>

          <div className="visual-card visual-card-accent">
            <span>Fast filters</span>
            <strong>Diet, time, difficulty</strong>
          </div>

          <div className="visual-card visual-card-accent soft">
            <span>Future flow</span>
            <strong>Sign in, personalize, discover dinner</strong>
          </div>
        </section>
      </main>

      <section className="feature-section">
        <div className="section-heading">
          <p className="eyebrow">What the app offers</p>
          <h2>A simple front page now, a stronger meal assistant later.</h2>
        </div>

        <div className="feature-grid">
          {featureCards.map((card) => (
            <article className="feature-card" key={card.title}>
              <h3>{card.title}</h3>
              <p>{card.description}</p>
            </article>
          ))}
        </div>
      </section>
    </div>
  );
}

export default App;
